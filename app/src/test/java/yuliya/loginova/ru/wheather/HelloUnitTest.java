package yuliya.loginova.ru.wheather;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloUnitTest {
    @Test
    public void BuilderGreetingPhrase_Test() throws Exception{
        BuilderGreeringPhrase builderGreeringPhrase = new BuilderGreeringPhrase(new GreetingStrings() {
            @Override
            public String getHelloer() {
                return "GeekBrains";
            }

            @Override
            public String getMorning() {
                return "Good Morning";
            }

            @Override
            public String getAfternoon() {
                return "Good afternoon";
            }

            @Override
            public String getEvening() {
                return "Good evening";
            }

            @Override
            public String getNight() {
                return "Good night";
            }
        });
        assertEquals("Good afternoon, GeekBrains!", builderGreeringPhrase.get());
    }
}
