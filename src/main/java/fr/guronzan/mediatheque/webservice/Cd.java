/**
 * Cd.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.guronzan.mediatheque.webservice;

public class Cd  extends fr.guronzan.mediatheque.webservice.DomainObject  implements java.io.Serializable {
    private java.lang.String authorName;

    private int cdId;

    private fr.guronzan.mediatheque.webservice.CdKindType kind;

    private fr.guronzan.mediatheque.webservice.User[] owners;

    private byte[] picture;

    private java.util.Calendar releaseDate;

    private java.lang.String title;

    public Cd() {
    }

    public Cd(
           java.lang.String authorName,
           int cdId,
           fr.guronzan.mediatheque.webservice.CdKindType kind,
           fr.guronzan.mediatheque.webservice.User[] owners,
           byte[] picture,
           java.util.Calendar releaseDate,
           java.lang.String title) {
        this.authorName = authorName;
        this.cdId = cdId;
        this.kind = kind;
        this.owners = owners;
        this.picture = picture;
        this.releaseDate = releaseDate;
        this.title = title;
    }


    /**
     * Gets the authorName value for this Cd.
     * 
     * @return authorName
     */
    public java.lang.String getAuthorName() {
        return authorName;
    }


    /**
     * Sets the authorName value for this Cd.
     * 
     * @param authorName
     */
    public void setAuthorName(java.lang.String authorName) {
        this.authorName = authorName;
    }


    /**
     * Gets the cdId value for this Cd.
     * 
     * @return cdId
     */
    public int getCdId() {
        return cdId;
    }


    /**
     * Sets the cdId value for this Cd.
     * 
     * @param cdId
     */
    public void setCdId(int cdId) {
        this.cdId = cdId;
    }


    /**
     * Gets the kind value for this Cd.
     * 
     * @return kind
     */
    public fr.guronzan.mediatheque.webservice.CdKindType getKind() {
        return kind;
    }


    /**
     * Sets the kind value for this Cd.
     * 
     * @param kind
     */
    public void setKind(fr.guronzan.mediatheque.webservice.CdKindType kind) {
        this.kind = kind;
    }


    /**
     * Gets the owners value for this Cd.
     * 
     * @return owners
     */
    public fr.guronzan.mediatheque.webservice.User[] getOwners() {
        return owners;
    }


    /**
     * Sets the owners value for this Cd.
     * 
     * @param owners
     */
    public void setOwners(fr.guronzan.mediatheque.webservice.User[] owners) {
        this.owners = owners;
    }

    public fr.guronzan.mediatheque.webservice.User getOwners(int i) {
        return this.owners[i];
    }

    public void setOwners(int i, fr.guronzan.mediatheque.webservice.User _value) {
        this.owners[i] = _value;
    }


    /**
     * Gets the picture value for this Cd.
     * 
     * @return picture
     */
    public byte[] getPicture() {
        return picture;
    }


    /**
     * Sets the picture value for this Cd.
     * 
     * @param picture
     */
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }


    /**
     * Gets the releaseDate value for this Cd.
     * 
     * @return releaseDate
     */
    public java.util.Calendar getReleaseDate() {
        return releaseDate;
    }


    /**
     * Sets the releaseDate value for this Cd.
     * 
     * @param releaseDate
     */
    public void setReleaseDate(java.util.Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }


    /**
     * Gets the title value for this Cd.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Cd.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Cd)) return false;
        Cd other = (Cd) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.authorName==null && other.getAuthorName()==null) || 
             (this.authorName!=null &&
              this.authorName.equals(other.getAuthorName()))) &&
            this.cdId == other.getCdId() &&
            ((this.kind==null && other.getKind()==null) || 
             (this.kind!=null &&
              this.kind.equals(other.getKind()))) &&
            ((this.owners==null && other.getOwners()==null) || 
             (this.owners!=null &&
              java.util.Arrays.equals(this.owners, other.getOwners()))) &&
            ((this.picture==null && other.getPicture()==null) || 
             (this.picture!=null &&
              java.util.Arrays.equals(this.picture, other.getPicture()))) &&
            ((this.releaseDate==null && other.getReleaseDate()==null) || 
             (this.releaseDate!=null &&
              this.releaseDate.equals(other.getReleaseDate()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAuthorName() != null) {
            _hashCode += getAuthorName().hashCode();
        }
        _hashCode += getCdId();
        if (getKind() != null) {
            _hashCode += getKind().hashCode();
        }
        if (getOwners() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOwners());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOwners(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPicture() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPicture());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPicture(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReleaseDate() != null) {
            _hashCode += getReleaseDate().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Cd.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "cd"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "kind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "cdKindType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("owners");
        elemField.setXmlName(new javax.xml.namespace.QName("", "owners"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "user"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("picture");
        elemField.setXmlName(new javax.xml.namespace.QName("", "picture"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
