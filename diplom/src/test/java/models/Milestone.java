package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Milestone {
    private String name;
    private String description;
}
