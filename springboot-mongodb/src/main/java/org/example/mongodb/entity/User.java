package org.example.mongodb.entity;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class User implements Serializable {

    @Id
private Long userId;

    private String userName;

    private String sex;

    private String remark;

}
