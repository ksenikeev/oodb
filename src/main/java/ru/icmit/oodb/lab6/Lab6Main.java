package ru.icmit.oodb.lab6;

public class Lab6Main {


    public static void main(String[] args) {
        PathScan.find("ru.icmit.oodb.lab6.domain")
                .forEach(c->System.out.println(c.getCanonicalName()));
    }
}
