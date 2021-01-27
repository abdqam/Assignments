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
        console.log(`Name: ${this.name}, Stringth: ${this.stringth}, Speed: ${this.speed}, Health: ${this.health}`);
    }
    drinkSake(){
        this.health+=10;
        console.log(this.health);
    }
}
// const ninja1 = new Ninja("Hyabusa");
// ninja1.sayName();
// ninja1.showStats();
class Sensei extends Ninja{
    constructor(name){
        super(name);
        this.health=200;
        this.speed=10;
        this.stringth=10;
        this.wisdom=10;
    }
    speakWisdom(){
        super.drinkSake();
        console.log(`What one programmer can do in one month, two programmers can do in two months.`)
    }
}
const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
superSensei.showStats();