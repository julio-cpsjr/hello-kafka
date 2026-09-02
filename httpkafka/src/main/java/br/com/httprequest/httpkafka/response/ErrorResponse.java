package br.com.httprequest.httpkafka.response;

public record ErrorResponse(Integer status, String causa, String statusName) {
}
