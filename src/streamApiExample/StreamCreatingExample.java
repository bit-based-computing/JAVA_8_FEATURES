package streamApiExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreatingExample {
    public static void main(String[] args) {

        // Stream create from collection
        List<String> list = new ArrayList<>();
        list.add("string1");
        list.add("string2");
        System.out.println("print from list ");
        list.forEach(System.out::println);

        System.out.println("Print from stream");
        Stream<String> stringStream = list.stream();
        stringStream.forEach(System.out::println);

        // Stream create by factory method Stream.of(.....)
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        integerStream.forEach(item -> System.out.print(item + ", "));

        // Array to stream
        String [] cities = {"Dhaka","London", "Dubai"};
        Stream<String>citiesStream = Stream.of(cities);

        //Empty stream creating
        Stream<String> emptystream = Stream.empty();

        // infinite stream creating
        // it will product 1,2,4,6,16,32,64.................
        Stream<Integer> sequence = Stream.iterate(1,val -> val * 2 );
        // nee to short circuiting operation to stop this stream
        System.out.println();
        System.out.println("Sequence printing");
        sequence.limit(10).forEach(item -> System.out.print(item + ", "));

        // we can create another infinite stream and another short circuiting operation
        System.out.println();
        System.out.println("printing another sort circuit");
        Stream<Integer> sequence2 = Stream.iterate(1,val -> val <=10, val-> val + 1);
        sequence2.forEach(item -> System.out.print(item + ", "));
        System.out.println();

        // Make another infinite stream by generate method
        Stream<UUID> uuidStream = Stream.generate(UUID::randomUUID);
        Stream<Double> doubleStream = Stream.generate(Math::random);
        // Integer stream
        System.out.println("IntStream example rang and rangeClosed");
        IntStream.range(0,10).forEach(item -> System.out.print(item + ", "));
        System.out.println();
        IntStream.rangeClosed(0,10).forEach(item -> System.out.print(item + ", "));
        System.out.println();
        // BufferedReader stream example

        try{
            URL url = new URL("https://www.google.com/");
            URLConnection con = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            Stream<String> lines =reader.lines();
            lines.limit(2).forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }

        // bit stream example
        BitSet bitSet = new BitSet(8);
        bitSet.set(4);
        IntStream intStream = bitSet.stream();
        System.out.println("Bit set print");
        intStream.forEach(System.out::println);
    }
}
