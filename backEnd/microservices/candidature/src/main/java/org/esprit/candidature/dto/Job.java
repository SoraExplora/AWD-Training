package org.esprit.candidature.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private int id;
    private String title;
    private String description;
    private boolean available;
}
