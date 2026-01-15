package com.Juan.StephenKingBook.principal;

public interface IConvertirDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
