package com.know.hexagonalarchitecture.utils.exception;

public enum BusinessExceptionMessage {

    NUMBERPRICEEXCEPTION("El precio ingresado no es v'\u00E1'lido"),
    TYPEDOCUMENTINVALID("El tipo de documento es inv'\u00E1'lido"),
    NUMBERDOCUMENTINVALID("El n'\u00FA'mero de documento es inv'\u00E1'lido"),
    OBJECTINVALID("El campo no puede ir vac'\u00ED'o"),
    THEUSERISREGISTEREDBEFORE ("El usuario ya se encuentra registrado"),
    USERITCANTBEUPDATE ( "El usuario no se puede actualizar por que no está registrado"),
    PRODUCTCANTBEUPDATE ( "El producto no se puede actualizar , no está registrado"),
    PRODUCTREPEAT ( "El producto ya está registrado "),
    PRODUCTCANTBEDROP ( "El producto no se puede eliminar por que no existe"),
    USERCANTBEDELETE ("El usuario no se puede eliminar, es posible que no exista");


    BusinessExceptionMessage(String s) {
    }
}
