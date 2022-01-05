/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erhannis.clipboardinspector;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erhannis
 */
public class Main {
    public static void main(String[] args) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        for (DataFlavor flavor : clipboard.getAvailableDataFlavors()) {
            try {
                System.out.println("** " + flavor);
                Object o = clipboard.getData(flavor);
                if (o.getClass().isArray()) {
                    Class componentType = o.getClass().getComponentType();
                    if (char.class == componentType) {
                        System.out.println(Arrays.toString((char[])o));
                    } else if (boolean.class == componentType) {
                        System.out.println(Arrays.toString((boolean[])o));
                    } else if (byte.class == componentType) {
                        System.out.println(Arrays.toString((byte[])o));
                    } else if (short.class == componentType) {
                        System.out.println(Arrays.toString((short[])o));
                    } else if (int.class == componentType) {
                        System.out.println(Arrays.toString((int[])o));
                    } else if (long.class == componentType) {
                        System.out.println(Arrays.toString((long[])o));
                    } else if (float.class == componentType) {
                        System.out.println(Arrays.toString((float[])o));
                    } else if (double.class == componentType) {
                        System.out.println(Arrays.toString((double[])o));
                    } else {
                        System.out.println(Arrays.toString((Object[])o));
                    }
                } else {
                    System.out.println(o);
                }
                System.out.println();
            } catch (UnsupportedFlavorException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
