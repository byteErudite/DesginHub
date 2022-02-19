package com.vaibhav.design.LoLeD._designPatterns.creational.builder;

import java.util.StringJoiner;

import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.BodyType.CARBON_FIBRE;
import static com.vaibhav.design.LoLeD._designPatterns.creational.builder.Material.LEATHER;

public class BuilderImpl {
    public static void main(String[] args) {
        Automobile tesla = new Automobile.Builder()
                .brand("TESLA")
                .name("POWER_TRUCK")
                .model("SF9")
                .bodyType(CARBON_FIBRE)
                .engine(new V4())
                .stereo(new BassStereo())
                .tyre(new CosplyTyre())
                .seat(new N544("BROWN"))
                .build();
        System.out.println("Created automobile with info : "+tesla.getInfo());
    }

}

class Automobile {
    private final String name;
    private final String model;
    private final String brand;
    private final Tyre tyre;
    private final BodyType bodyType;
    private final Stereo stereo;
    private final Engine engine;
    private final Seat seat;

    static class Builder {
        private String name;
        private String model;
        private String brand;
        private Tyre tyre;
        private BodyType bodyType;
        private Stereo stereo;
        private Engine engine;
        private Seat seat;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder tyre(Tyre tyre) {
            this.tyre = tyre;
            return this;
        }

        public Builder bodyType(BodyType bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public Builder stereo(Stereo stereo) {
            this.stereo = stereo;
            return this;
        }

        public Builder engine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder seat(Seat seat) {
            this.seat = seat;
            return this;
        }

        public Automobile  build() {
            return new Automobile(this);
        }
    }

    public Automobile(Builder builder) {
        this.name = builder.name;
        this.bodyType = builder.bodyType;
        this.stereo = builder.stereo;
        this.tyre = builder.tyre;
        this.model = builder.model;
        this.brand = builder.brand;
        this.engine = builder.engine;
        this.seat = builder.seat;
    }
    public String getInfo() {
        return new StringJoiner(", ", this.name + "[", "]")
                .add("model='" + this.model + "'")
                .add("brand='" + this.brand + "'")
                .add("tyre=" + this.tyre.getInfo())
                .add("bodyType=" + this.bodyType)
                .add("stereo=" + this.stereo.getInfo())
                .add("engine=" + this.engine.getInfo())
                .add("seat=" + this.seat.getInfo())
                .toString();
    }
}

abstract class Stereo {
    abstract String getName();
    abstract int getMaxDecibal();
    public String getInfo() {
        return "name : "+getName()+ " maximum decibal : "+getMaxDecibal();
    }
}

class BassStereo extends Stereo{

    @Override
    String getName() {
        return "BassStereo";
    }

    @Override
    int getMaxDecibal() {
        return 100;
    }
}

abstract class Seat {
    abstract public String getColour();
    abstract public Material getMaterial();
    abstract boolean getIsPolished();
    public String getInfo() {
        return "color : "+getColour()+ " material : "+getMaterial() + " polished : "+getIsPolished();
    }
}


class N544 extends Seat{

    private String colour;
    N544(String colour) {
        this.colour = colour;
    }
    @Override
    public String getColour() {
        return this.colour;
    }

    @Override
    public Material getMaterial() {
        return LEATHER;
    }

    @Override
    boolean getIsPolished() {
        return true;
    }
}

abstract class Engine {
    abstract int getHorsePower();
    abstract String getBrand();

    public String getInfo() {
        return "horsePower : "+getHorsePower()+ " brand : "+getBrand();
    }
}

class V4 extends Engine{

    @Override
    int getHorsePower() {
        return 785;
    }

    @Override
    String getBrand() {
        return "Ducati";
    }

}

abstract class Tyre {
    String brand;
    int radius;

    public String getInfo() {
        return new StringJoiner(", ", "" + "[", "]")
                .add("brand='" + brand + "'")
                .add("radius=" + radius)
                .toString();
    }
}

class CosplyTyre extends Tyre {
    public CosplyTyre() {
        brand = "MRF";
        radius=5;
    }
}

class RadialplyTyre extends Tyre {

    public RadialplyTyre() {
        brand = "CEAT";
        radius=6;
    }
}

enum BodyType {
    ALUMINIUM, CARBON_FIBRE
}

enum Material {
    LEATHER, CARGO, REXIN
}
