package com.gsm.bean;

import lombok.Data;

import java.sql.Timestamp;

@Data // 使用 Lombok 的 @Data 注解来自动生成 getter/setter/toString 等方法
public class Graduate {

    private Integer graduateId; // 对应于表中的 `graduate_id`
    private Integer collegeId; // 对应于表中的 `college_id`
    private String name; // 对应于表中的 `name`
    private String studentNumber; // 对应于表中的 `student_number`
    private String gender; // 对应于表中的 `gender`
    private String major; // 对应于表中的 `major`
    private Integer graduationYear; // 对应于表中的 `graduation_year`
    private String degree; // 对应于表中的 `degree`
    private Timestamp createdAt; // 对应于表中的 `created_at`
    private Timestamp updatedAt; // 对应于表中的 `updated_at`

    // 如果你不使用 Lombok，你需要手动添加以下内容：
    // - 默认构造函数和带参数的构造函数
    // - Getter 和 Setter 方法
    // - toString 方法
    // - equals 和 hashCode 方法（如果需要的话）

    // 你可以添加一个方法来设置或获取关联的 College 对象，例如：
    // private College college;
}