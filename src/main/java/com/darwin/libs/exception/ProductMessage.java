package com.darwin.libs.exception;

/**
 * Constants to manage the product messages.
 *
 * @author Team Backend Darwin
 */
public class ProductMessage {

  public static final String PRODUCT_NAME_EMPTY =
      "Debes ingresar un nombre del producto válido";
  public static final String PRODUCT_NAME_SHORT =
      "Debes ingresar un nombre de producto de mayor longitud";
  public static final String PRODUCT_NAME_LONG =
      "Debes ingresar un nombre de producto de menor longitud";

  public static final String BARCODE_TOO_SHORT =
      "Debes ingresar un barcode de producto de mayor longitud";
  public static final String BARCODE_TOO_LONG =
      "Debes ingresar un barcode de producto de menor longitud";
  public static final String PRODUCT_CATEGORY_EMPTY =
      "Debes ingresar una categoria del producto válida";
  public static final String PRODUCT_PRESENTATION_EMPTY =
      "Debes ingresar una presentación del producto válida";


  public static final String SUBCATEGORY_GUID_EMPTY =
      "Debes ingresar guid de subcategoria válida";

  private ProductMessage() {
  }

}
