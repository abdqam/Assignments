package com.objectmaster;

public class HumanTest {
    public static void main(String[] args) {
        Human human1=new Human(5,5,5,100);
        Human human2=new Human();
        Wizard wizard = new Wizard();
        Samurai samurai= new Samurai();
        Ninja ninja = new Ninja();
        Samurai samurai1 = new Samurai();

        wizard.fireball(samurai);
        System.out.println(samurai.getHealth());
        samurai.deathBlow(human2);
        System.out.println(human2.getHealth());
        System.out.println(samurai.getHealth());
        ninja.steal(wizard);
        System.out.println(ninja.getHealth());

        ninja.runAway();
        System.out.println(ninja.getHealth());
        System.out.println(wizard.getHealth());
        System.out.println(Samurai.hoeMany_static());
    }

}
