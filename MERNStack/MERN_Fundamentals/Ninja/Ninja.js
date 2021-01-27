class Ninja{
    constructor(name){
this.name=name;
this.health=100;
this.speed=3;
this.stringth=3;
    }
    sayName(){
        console.log(`Ninja's name ${this.name}`);
    }
    showStats(){
        console.log(`Ninja's name ${this.name}, Ninja's stringth ${this.stringth}, Ninja's speed ${this.speed}, Ninja's health ${this.health}`);
    }
    drinkSake(){
        this.health=+10;
    }
}
const ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.showStats();