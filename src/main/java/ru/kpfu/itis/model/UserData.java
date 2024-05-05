package ru.kpfu.itis.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class UserData {

    @XmlElement
    private String password;
    @XmlElement
    private String email;
    @XmlElement
    private String noteText;
    @XmlElement
    private String baseUrl;
}
