package org.example.exercice1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> mots = Arrays.asList("Java", "Python", "JavaScript", "Ruby", "C#", "C++");

        List<String> filteredWithA = mots.stream()
                .filter(s -> s.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Mots contenant 'a': " + filteredWithA);

        List<String> transformed = mots.stream()
                .filter(s -> s.length() > 3)
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.toList());
        System.out.println("Mots inversés avec longueur > 3: " + transformed);

        List<Character> flatMappedCharacters = mots.stream()
                .filter(s -> s.contains("e"))
                .flatMapToInt(CharSequence::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("Caractères des mots contenant 'e': " + flatMappedCharacters);

        List<String> upperCaseStrings = mots.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Mots en majuscules: " + upperCaseStrings);

        List<Integer> lengths = mots.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Longueurs des mots: " + lengths);

        List<Character> flatMappedCharactersAll = mots.stream()
                .flatMapToInt(CharSequence::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("Caractères de tous les mots: " + flatMappedCharactersAll);

        List<String> transformedNames = IntStream.range(0, mots.size())
                .mapToObj(i -> mots.get(i) + " - " + i)
                .collect(Collectors.toList());
        System.out.println("Noms avec index: " + transformedNames);
    }
}
