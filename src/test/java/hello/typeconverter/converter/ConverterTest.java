package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @Test
    void stringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void IntegerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort() {
        IpPortToStringConverter converter = new IpPortToStringConverter(); //IpPort 객체를 받아 String 으로 변환
        IpPort source = new IpPort("127.0.0.1", 8080); //IpPort 객체의 인스턴스 생성
        String result = converter.convert(source); //IpPort 를 파라미터로 넘기면 String 으로 변환해서 리턴
        assertThat(result).isEqualTo("127.0.0.1:8080"); //스트링으로 변환 되었는지 확인
    }

    @Test
    void ipPortToString() {
        StringToIpPortConverter converter = new StringToIpPortConverter(); //String 을 받아 IpPort 객체로 변환
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source); //String 을 파라미터로 넘기면 IpPort 객체로 변환해서 리턴
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080)); //IpPort.java 에서 @EqualsAndHashCode 사용했기에 가능
    }
}
