package edu.haramaya.cosc3053;

public class EnvironmentDiagnostic {
    static void main(String[] args) {
        System.out.println("================================");
        System.out.println("Java Enviroment Diadnostic Trase");
        System.out.println("================================");
        System.out.println("java Version:"+System.getProperty("java.version"));
        System.out.println("java Vendor:"+System.getProperty("java.vender"));
        System.out.println("OS Name :"+System.getProperty("os.name"));
        System.out.println("OS Arch :"+System.getProperty("os.arch"));
        System.out.println("User Name :"+System.getProperty("user.name"));
        System.out.println("================================");

    }
}
