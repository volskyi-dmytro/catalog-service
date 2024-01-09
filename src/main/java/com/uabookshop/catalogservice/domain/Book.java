package com.uabookshop.catalogservice.domain;

public record Book (
    String isbn,
    String title,
    String author,
    Double price
){}
