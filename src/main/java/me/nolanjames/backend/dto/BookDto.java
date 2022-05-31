package me.nolanjames.backend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "BookDto", description = "All details about book")
public class BookDto {

    @ApiModelProperty(value = "UUID", dataType = "UUID", example = "49ae2e31-4821-4412-a9cc-c8ebb5043a9a",
            notes = "The database generates the uuid", required = true)
    private UUID id;

    @ApiModelProperty(value = "title", dataType = "String", example = "BooK Title",
            notes = "Title of the book", required = true)
    private String title;

    @ApiModelProperty(value = "description", dataType = "String", example = "Book Description",
            notes = "Description of the book", required = true)
    private String description;

    @ApiModelProperty(value = "releaseYear", dataType = "int", example = "2022",
            notes = "Release year for the book", required = true)
    private int releaseYear;

}
