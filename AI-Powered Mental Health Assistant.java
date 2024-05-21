<dependency>
  <groupId>edu.stanford.nlp</groupId>
  <artifactId>stanford-corenlp</artifactId>
  <version>4.4.0</version>
</dependency>
<dependency>
  <groupId>edu.stanford.nlp</groupId>
  <artifactId>stanford-corenlp</artifactId>
  <version>4.4.0</version>
  <classifier>models</classifier>
</dependency>








import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.sentiment.*;
import edu.stanford.nlp.util.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Set up the pipeline properties
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,parse,sentiment");

        // Build the pipeline
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // Input text (In a real application, this would be user input)
        String text = "I'm feeling very happy today! But sometimes I feel very sad.";

        // Create an annotation object
        Annotation annotation = new Annotation(text);

        // Annotate the text
        pipeline.annotate(annotation);

        // Get the sentences from the annotated text
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);

        // Process each sentence for sentiment
        for (CoreMap sentence : sentences) {
            String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            System.out.println(sentence.toString() + " - Sentiment: " + sentiment);
        }
    }
}
