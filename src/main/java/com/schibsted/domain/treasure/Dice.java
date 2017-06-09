package com.schibsted.domain.treasure;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by alberto.esposito on 9/6/17.
 */
public class Dice {
  public static Supplier<Treasure> roll(Supplier<Treasure> a, Supplier<Treasure> b, Supplier<Treasure> c){
    Random rand = new SecureRandom();
    int number = rand.nextInt(101);
    System.out.println("number::" + number);
    if (number >= 80) {
      return a;
    } else if (number < 10) {
      return b;
    }
    else {
      return c;
    }
  }
}
