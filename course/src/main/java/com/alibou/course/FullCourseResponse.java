package com.alibou.course;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullCourseResponse {

    private String name;
    private String email;
    List<com.mounir.course.Student> students;
}
