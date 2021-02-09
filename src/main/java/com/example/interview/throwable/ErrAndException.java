package com.example.interview.throwable;

import java.io.FileNotFoundException;

public class ErrAndException {

    public static void main(String[] args) {
        ErrAndException eae = new ErrAndException();
        try {
            eae.throwCheckedException();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void throwCheckedException() throws FileNotFoundException {
        // must be caught
        throw new FileNotFoundException();

    }

}
