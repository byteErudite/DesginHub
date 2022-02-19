package com.vaibhav.design.LoLeD._designPatterns.creational.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.BatterIngredient.CHEESE;
import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.BatterIngredient.GARLIC;
import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.BatterIngredient.MASHED_POTATO;
import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.Size.LARGE;

public class ChildParentBuilderImpl {
    public static void main(String[] args) {
        MasalaDosa masalaDosa = new MasalaDosa.Builder(LARGE)
                .addIngredient(GARLIC)
                .addIngredient(CHEESE)
                .build();
        System.out.println(masalaDosa.toString());
    }
}

class Dosa {
    private Set<BatterIngredient> batter;

    abstract static class Builder<T extends Builder<T>> {
        private EnumSet<BatterIngredient> batter = EnumSet.noneOf(BatterIngredient.class);
        public T addIngredient(BatterIngredient ingredient) {
            batter.add(Objects.requireNonNull(ingredient));
            return self();
        }
        abstract Dosa build();
        protected abstract T self();
    }

    public Set<BatterIngredient> getBatter() {
        return batter;
    }

    Dosa(Builder<?> builder) {
        batter = builder.batter.clone();
    }
}

class MasalaDosa extends Dosa {
    private final Size size;
    private final String name;
    public static class Builder extends Dosa.Builder<Builder> {
        private final Size size;
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }
        @Override public MasalaDosa build() {
            return new MasalaDosa(this);
        }
        @Override protected Builder self() { return this; }

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Builder.class.getSimpleName() + "[", "]")
                .add("size=" + size)
                .add("name=" + name)
                .add("ingredients" +  super.getBatter().stream().map(String::valueOf).collect(Collectors.toList()))
                .toString();
    }
    private MasalaDosa(Builder builder) {
        super(builder.addIngredient(MASHED_POTATO).addIngredient(GARLIC));
        size = builder.size;
        name = "Masala Dosa";
    }
    
}

enum BatterIngredient {ONION, RAVA, CHEESE, GARLIC, CINEMON, CARDAMOM, RED_CHILLIE,MASHED_POTATO}
enum Size { SMALL, MEDIUM, LARGE }