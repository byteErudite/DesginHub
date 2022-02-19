package com.vaibhav.design.LoLeD._designPatterns.creational.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.BatterIngredient.CHEESE;
import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.BatterIngredient.GARLIC;
import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.BatterIngredient.MASHED_POTATO;
import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.BatterIngredient.ONION;
import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.BatterIngredient.RED_CHILLIE;
import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.Size.LARGE;
import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.Size.SMALL;

public class ChildParentBuilderImpl {
    public static void main(String[] args) {
        Dosa masalaDosa = new MasalaDosa.Builder(LARGE)
                .addIngredient(GARLIC)
                .addIngredient(CHEESE)
                .build();
        Dosa onionDosa = new OnionDosa.Builder(SMALL, 1)
                .addIngredient(GARLIC)
                .addIngredient(CHEESE)
                        .build();
        System.out.println(masalaDosa.toString());
        System.out.println(onionDosa.toString());
    }
}

class Dosa {
    private Set<BatterIngredient> batter;
    private final String name;
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

    public String getName() {
        return name;
    }

    Dosa(Builder<?> builder, String name) {
        this.name = name;
        batter = builder.batter.clone();
    }
}

class MasalaDosa extends Dosa {
    private final Size size;
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
                .add("name=" + getName())
                .add("ingredients" +  super.getBatter().stream().map(String::valueOf).collect(Collectors.toList()))
                .toString();
    }
    private MasalaDosa(Builder builder) {
        super(builder.addIngredient(MASHED_POTATO).addIngredient(GARLIC), "Masala Dosa");
        size = builder.size;
    }
}

class OnionDosa extends Dosa {
    private final Size size;
    private final int onionQuantity;
    public static class Builder extends Dosa.Builder<Builder> {
        private final Size size;
        private final int onionQuantity;
        public Builder(Size size, int onionQuantity) {
            this.onionQuantity = onionQuantity;
            this.size = Objects.requireNonNull(size);
        }
        @Override public OnionDosa build() {
            return new OnionDosa(this);
        }
        @Override protected Builder self() { return this; }

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Builder.class.getSimpleName() + "[", "]")
                .add("size=" + size)
                .add("onionQuantity=" + onionQuantity)
                .add("name=" + getName())
                .add("ingredients" +  super.getBatter().stream().map(String::valueOf).collect(Collectors.toList()))
                .toString();
    }
    private OnionDosa(Builder builder) {
        super(builder.addIngredient(MASHED_POTATO).addIngredient(ONION).addIngredient(RED_CHILLIE), "Onion Dosa");
        size = builder.size;
        onionQuantity = builder.onionQuantity;
    }
}

enum BatterIngredient {ONION, RAVA, CHEESE, GARLIC, CINEMON, CARDAMOM, RED_CHILLIE,MASHED_POTATO}
enum Size { SMALL, MEDIUM, LARGE }