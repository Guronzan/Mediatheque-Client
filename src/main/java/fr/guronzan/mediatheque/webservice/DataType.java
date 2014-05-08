/**
 * DataType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.guronzan.mediatheque.webservice;

public class DataType implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -2529898354420831762L;
    private final java.lang.String _value_;
    private static java.util.HashMap<String, DataType> _table_ = new java.util.HashMap<>();

    // Constructor
    protected DataType(final java.lang.String value) {
        this._value_ = value;
        _table_.put(this._value_, this);
    }

    public static final java.lang.String _MOVIE = "MOVIE";
    public static final java.lang.String _MUSIC = "MUSIC";
    public static final java.lang.String _BOOK = "BOOK";
    public static final DataType MOVIE = new DataType(_MOVIE);
    public static final DataType MUSIC = new DataType(_MUSIC);
    public static final DataType BOOK = new DataType(_BOOK);

    public java.lang.String getValue() {
        return this._value_;
    }

    public static DataType fromValue(final java.lang.String value)
            throws java.lang.IllegalArgumentException {
        final DataType enumeration = _table_.get(value);
        if (enumeration == null) {
            throw new java.lang.IllegalArgumentException();
        }
        return enumeration;
    }

    public static DataType fromString(final java.lang.String value)
            throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }

    @Override
    public boolean equals(final java.lang.Object obj) {
        return obj == this;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public java.lang.String toString() {
        return this._value_;
    }

    public java.lang.Object readResolve() throws java.io.ObjectStreamException {
        return fromValue(this._value_);
    }

    public static org.apache.axis.encoding.Serializer getSerializer(
            final java.lang.String mechType, final java.lang.Class _javaType,
            final javax.xml.namespace.QName _xmlType) {
        return new org.apache.axis.encoding.ser.EnumSerializer(_javaType,
                _xmlType);
    }

    public static org.apache.axis.encoding.Deserializer getDeserializer(
            final java.lang.String mechType, final java.lang.Class _javaType,
            final javax.xml.namespace.QName _xmlType) {
        return new org.apache.axis.encoding.ser.EnumDeserializer(_javaType,
                _xmlType);
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
            DataType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName(
                "http://webservice.mediatheque.guronzan.fr/", "dataType"));
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
