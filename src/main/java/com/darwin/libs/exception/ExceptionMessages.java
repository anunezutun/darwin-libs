package com.darwin.libs.exception;

/**
 * Constants to manage the exception messages for the app.
 *
 * @author Team Backend Darwin
 */
public class ExceptionMessages {

  public static final String IMAGE_RESOURCE_EMPTY =
      "El valor de la imagen no puede ser nulo o vacío";
  public static final String USER_USERNAME_EMPTY =
      "El nombre de usuario no puede ser nulo o vacío";
  public static final String USER_FIRST_NAME_EMPTY =
      "El nombre del usuario no puede ser nulo o vacío";
  public static final String USER_PASSWORD_EMPTY =
      "El password no puede ser nulo o vacío";
  public static final String USER_PHONE_EMPTY =
      "El telefóno no puede ser nulo o vacío";
  public static final String PRODUCT_LIST_LIMIT_BAD_VALUE =
      "El parámetro limit es obligatorio y debe ser mayor o igual a 1";
  public static final String PRODUCT_LIST_PAGE_BAD_VALUE =
      "El parámetro page es obligatorio y debe ser mayor o igual a 0";
  public static final String PRODUCT_LIST_NOT_FOUND =
      "No hay productos registrados.\nComunícate con tu asesor";
  public static final String PAYMENT_TYPE_NAME_EMPTY =
      "Debes ingresar un nombre del tipo de pago válido";
  public static final String PAYMENT_TYPE_DESCRIPTION_EMPTY =
      "Debes ingresar una descripción del tipo de pago válida";
  public static final String PAYMENT_TYPE_GUID_EMPTY =
      "Debes ingresar una guid del tipo de pago válida";
  public static final String PRODUCT_GUID_EMPTY =
      "Debes ingresar una guid de producto válida";
  public static final String INVOICE_TYPE_NAME_EMPTY =
      "Debes ingresar un nombre del tipo de comprobante válido";
  public static final String INVOICE_TYPE_DESCRIPTION_EMPTY =
      "Debes ingresar una descripción del tipo de comprobante válida";
  public static final String INVOICE_TYPE_GUID_EMPTY =
      "Debes ingresar una guid del tipo de comprobante válida";
  public static final String SALE_ITEM_GUID_EMPTY =
      "Debes ingresar un identificador de producto de un ítem válido";
  public static final String SALE_ITEM_MINIMUM_QUANTITY =
      "Debes ingresar una cantidad de producto de un ítem mayor o igual a 1";
  public static final String SALE_ITEM_MAXIMUM_QUANTITY =
      "La cantidad de producto de un ítem excede el límite (máximo 9999 unidades)";
  public static final String SALE_ITEMS_EMPTY =
      "La lista de ítems debe tener por lo menos un elemento";
  public static final String SALE_MINIMUM_SUBTOTAL =
      "El subtotal de la venta debe ser mayor o igual a 0.10";
  public static final String SALE_MINIMUM_DISCOUNT =
      "El descuento de la venta debe ser mayor o igual a 0.00";
  public static final String PRODUCT_MINIMUM_PRICE =
      "El precio del producto debe ser mayor o igual a 0.00";
  public static final String PRODUCT_MAXIMUM_PRICE =
      "El valor ingresado excede los límites autorizados";
  public static final String SALE_MINIMUM_TOTAL =
      "El total de la venta debe ser mayor o igual a 0.10";
  public static final String SALE_MAXIMUM_VALUES =
      "El valor ingresado excede los límites autorizados";
  public static final String UM_MINIMUM_TOTAL =
      "El total de la venta debe ser mayor o igual a 0.00";
  public static final String UM_MAXIMUM_VALUES =
      "El valor ingresado excede los límites autorizados";
  public static final String SALE_REPORT_LIMIT_BAD_VALUE =
      "El parámetro limit es obligatorio y debe ser mayor o igual a 1";
  public static final String SALE_REPORT_PAGE_BAD_VALUE =
      "El parámetro page es obligatorio y debe ser mayor o igual a 0";
  public static final String SALE_REPORT_NOT_FOUND =
      "Aún no tienes ventas\nGenera tu primera venta para visualizar tu reporte";
  public static final String SALE_DETAIL_BAD_FORMAT_GUID =
      "Debes ingresar un identificador de venta válido";
  public static final String PAYMENT_TYPE_LIST_NOT_FOUND =
      "No se encontraron tipos de pago registrados";
  public static final String INVOICE_TYPE_LIST_NOT_FOUND =
      "No se encontraron comprobantes registrados";
  public static final String INTERNAL_FAIL_LOADING_DATA =
      "Ha sucedido un error.\nComunícate con tu asesor.";
  public static final String GROCERY_BUSINESS_NAME_EMPTY =
      "Debes ingresar un nombre de negocio válido";
  public static final String GROCERY_DOCUMENT_TYPE_EMPTY =
      "Debes ingresar un tipo de documento válido";
  public static final String GROCERY_DOCUMENT_NUMBER_EMPTY =
      "Debes ingresar un número de documento válido";
  public static final String GROCERY_USER_ITEMS_EMPTY =
      "La lista de ítems no debe estar vacía";
  public static final String GROCERY_USER_DOCUMENT_NUMBER_EMPTY =
      "Debes ingresar un número de documento válido";
  public static final String GROCERY_USER_DOCUMENT_TYPE_EMPTY =
      "Debes ingresar un tipo de documento válido";
  public static final String GROCERY_TRADE_NAME_EMPTY =
      "Debes ingresar un nombre comercial válido";
  public static final String GROCERY_ADDRESS_EMPTY =
      "Debes ingresar una dirección válida";
  public static final String GROCERY_USER_SECONDARY_LAST_NAME_EMPTY =
      "Debes ingresar un segundo apellido válido";
  public static final String USER_DOCUMENT_NUMBER_EMPTY =
      "Debes ingresar un número de documento válido";
  public static final String USER_DOCUMENT_TYPE_EMPTY =
      "Debes ingresar un tipo de documento válido";
  public static final String USER_FIRST_LAST_NAME_EMPTY =
      "Debes ingresar un primer apellido válido";
  public static final String USER_SECONDARY_LAST_NAME_EMPTY =
      "Debes ingresar un segundo apellido válido";
  public static final String USER_GROCERY_GUID_EMPTY =
      "Debes ingresar ID de bodega válido";
  public static final String USER_INVALID_PARAMETER =
      "La información del usuario ingresada es incorrecta. "
          + "Por favor, revisa los valores ingresados";
  public static final String USER_PHONE_INVALID =
      "El número de teléfono debe contener 9 dígitos";
  public static final String USER_OWNER_NULL =
      "El campo Owner solo acepta los valores: true o false";
  public static final String USER_ACTIVE_NULL =
      "El campo Active solo acepta los valores: true o false";
  public static final String USER_USERNAME_MAX =
      "El nombre de usuario ingresado no debe contener más de 40 caracteres";
  public static final String USER_PASSWORD_MAX =
      "La contraseña ingresada no debe contener más de 40 caracteres";
  public static final String USER_EMAIL_INVALID =
      "El email ingresado no tiene el formato correcto";
  public static final String USER_DOCUMENT_NUMBER_EXISTS =
      "El usuario ingresado ya se encuentra registrado";
  public static final String DUPLICATE_GROCERY =
      "La bodega ya se encuentra registrada";
  public static final String CATEGORY_NAME_EMPTY =
      "Debes ingresar un nombre de la categoría válido";

  public static final String UM_GUID_EMPTY =
      "Debes ingresar un guid de la unidad de medida válida";
  public static final String CATEGORY_EXISTS =
      "La categoría ya se encuentra registrada";
  public static final String SUBCATEGORY_NAME_EMPTY =
      "Debes ingresar un nombre de la sub categoría válido";
  public static final String LIST_SUBCATEGORY_BAD_FORMAT_GUID =
      "Debes ingresar un identificador de categoría válido";
  public static final String CONTAINER_NAME_EMPTY =
      "Debes ingresar un nombre del envase válida";
  public static final String CONTAINER_CODE_EMPTY =
      "Debes ingresar un codigo del envase válida";
  public static final String CONTAINER_DESCRIPTION_EMPTY =
      "Debes ingresar una descripción del envase válida";

  public static final String UNIT_MEASURE_NAME_EMPTY =
      "Debes ingresar un nombre de la unidad de medida válida";
  public static final String UNIT_MEASURE_CODE_EMPTY =
      "Debes ingresar un codigo de la unidad de medida válida";
  public static final String UNIT_MEASURE_DESCRIPTION_EMPTY =
      "Debes ingresar una descripción de la unidad de medida válida";
  public static final String LOGIN_AUTHENTICATION_FAILED_ERROR =
      "Por favor revisa tu DNI y contraseña";
  public static final String LOGIN_VALIDATION_FAILED_ERROR =
      "Usuario no autorizado\nComunícate con tu asesor.";
  public static final String POLICY_UPDATE_NULL =
      "Se debe ingresar la validación de la política de privacidad";
  public static final String CONSENT_UPDATE_NULL =
      "Se debe ingresar la validación del consentimiento de uso de datos";

  public static final String ERROR_MESSAGE_NO_ASSOCIATION_CATEGORY =
          "No se ha encontrado una asociación con la CategorÍa";

  private ExceptionMessages() {
    throw new IllegalStateException("Utility class");
  }

}
