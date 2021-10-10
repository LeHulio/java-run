package ru.tuanviet.javabox;


import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    static JsonReaderTest jsonReaderTest;
    static NamesParser namesParser;
    static NounsParser nounsParser;
    static String responseName;
    static String responseNoun;
    static List<String> responseNameList;
    static List<String> responseNounList;

    @BeforeClass
    public static void setUpOkHttp() throws IOException {
        jsonReaderTest = new JsonReaderTest();
        namesParser = new NamesParser();
        nounsParser = new NounsParser();
        responseName = jsonReaderTest.getResponseFromJsonFileTest("C:\\Users\\alexm\\IdeaProjects\\java-run-sample\\src\\test\\resources\\names.json");
        responseNoun = jsonReaderTest.getResponseFromJsonFileTest("C:\\Users\\alexm\\IdeaProjects\\java-run-sample\\src\\test\\resources\\nouns.json");
        responseNameList = namesParser.responseToList(responseName);
        responseNounList = nounsParser.responseToList(responseNoun);
    }


    public AppTest() throws IOException {
    }


    @Test
    public void shouldReturnNameResponse() throws IOException {
        String namesStr = "{\"names\":[\"АЛЕКСАНДР\",\"СОФИЯ\"]}";
        assertThatJson(responseName.contains(namesStr));
    }

    @Test
    public void shouldReturnNounResponse() throws IOException {
        String nounsStr = "\\[\"абажур\",\"абажурчик\",\"абаз\"\\]";
        assertThatJson(responseNoun.contains(nounsStr));
    }

    @Test
    public void shouldCreateNameList() throws IOException {
        List<String> testList = Arrays.asList("АЛЕКСАНДР", "СОФИЯ");
        assertThat(responseNameList.get(0)).isEqualTo(testList.get(0));
        assertThat(responseNameList.get(1)).isEqualTo(testList.get(1));
    }

    @Test
    public void shouldCreateNounList() throws IOException {
        List<String> testList = Arrays.asList("абажур", "абажурчик");
        assertThat(responseNounList.get(0)).isEqualTo(testList.get(0));
        assertThat(responseNounList.get(1)).isEqualTo(testList.get(1));
    }

    @Test
    public void shouldCreateDifferentRandoms() throws IOException {
        String random1 = GenerateRandomFullNames.generateRandomFullName(responseNameList, responseNounList);
        String random2 = GenerateRandomFullNames.generateRandomFullName(responseNameList, responseNounList);
        assertThat(random1).isNotEqualTo(random2);
    }


}
