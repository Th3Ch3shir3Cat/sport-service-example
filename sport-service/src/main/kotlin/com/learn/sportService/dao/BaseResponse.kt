package com.learn.sportService.dao

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class BaseResponse (
    @JsonProperty("msg")
    val msg: String
)