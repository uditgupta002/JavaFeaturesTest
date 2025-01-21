import java.util.List;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

// Java 23 now allows for implicitly declared classes and instance main methods
void main(String[] args) {
    List<Integer> simulatedStream = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    testStreamGatherer(simulatedStream.stream());
}

void testStreamGatherer(Stream<Integer> integerStream) {
    integerStream.gather(Gatherers.windowFixed(3))
            .forEach(System.out::println);
}