package com.azabost.core;

import javax.enterprise.context.RequestScoped;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class Fibonacci {

    public BigInteger getNthElementOfSequence(Integer number){
        BigInteger result = BigInteger.valueOf(0);
        if (number == 1){
            return BigInteger.valueOf(1);
        }else {
            BigInteger b = BigInteger.valueOf(0);
            BigInteger a = BigInteger.valueOf(1);
            for (int i = 0; i < number - 1; i++) {
                result = a.add(b);
                b = a;
                a = result;
            }
        }
        return result;
    }

    public List<BigInteger> getAllSequence(Integer number){
        List<BigInteger> result = new ArrayList<>();
        BigInteger c;
        if (number <= 0){
            result.add(BigInteger.valueOf(0));
            return result;
        }else {
            result.add(BigInteger.valueOf(1));
            BigInteger b = BigInteger.valueOf(0);
            BigInteger a = BigInteger.valueOf(1);
            for (int i = 0; i < number - 1; i++) {
                c = a.add(b);
                b = a;
                a = c;
                result.add(c);
            }
        }
        return result;
    }
}
