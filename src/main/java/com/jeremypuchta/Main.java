package com.jeremypuchta;

import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {
        String encodedId = encode(12345);
        System.out.println("Encoded ID: " + encodedId);
        System.out.println("Decoded String: " + decode(encodedId));
    }

    private static String encode(int id) {
        // Map to store 62 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuffer shorturl = new StringBuffer();

        // Convert given integer id to a base 62 number
        while (id > 0)
        {
            // use above map to store actual character
            // in short url
            shorturl.append(map[id % 62]);
            id = id / 62;
        }

        // Reverse shortURL to complete base conversion
        return shorturl.reverse().toString();
    }

    private static int decode(final String shortUrl) {
        int id = 0; // initialize result

        // A simple base conversion logic
        for (int i = 0; i < shortUrl.length(); i++)
        {
            if ('a' <= shortUrl.charAt(i) &&
                    shortUrl.charAt(i) <= 'z')
                id = id * 62 + shortUrl.charAt(i) - 'a';
            if ('A' <= shortUrl.charAt(i) &&
                    shortUrl.charAt(i) <= 'Z')
                id = id * 62 + shortUrl.charAt(i) - 'A' + 26;
            if ('0' <= shortUrl.charAt(i) &&
                    shortUrl.charAt(i) <= '9')
                id = id * 62 + shortUrl.charAt(i) - '0' + 52;
        }
        return id;
    }
}