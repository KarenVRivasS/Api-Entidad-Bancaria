package com.accenture.entidades_bancarias_api.exception;

public class RecursoNoEncontradoException extends RuntimeException {


    private static final long serialVersionUID = 1L;
    private String codigo;
    private String descripcion;

    public RecursoNoEncontradoException(String message) {
        super(message);
    }

    public RecursoNoEncontradoException(String codigo, String descripcion) {
        super("");
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}
