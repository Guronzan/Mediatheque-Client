/**
 * Movie.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.guronzan.mediatheque.webservice;

public class Movie  extends fr.guronzan.mediatheque.webservice.DomainObject  implements java.io.Serializable {
    private java.lang.String directorName;

    private int movieId;

    private boolean ownedDVD;

    private fr.guronzan.mediatheque.webservice.User[] owners;

    private byte[] picture;

    private java.util.Calendar releaseDate;

    private java.lang.Integer season;

    private java.lang.String title;

    private fr.guronzan.mediatheque.webservice.VideoType type;

    public Movie() {
    }

    public Movie(
           java.lang.String directorName,
           int movieId,
           boolean ownedDVD,
           fr.guronzan.mediatheque.webservice.User[] owners,
           byte[] picture,
           java.util.Calendar releaseDate,
           java.lang.Integer season,
           java.lang.String title,
           fr.guronzan.mediatheque.webservice.VideoType type) {
        this.directorName = directorName;
        this.movieId = movieId;
        this.ownedDVD = ownedDVD;
        this.owners = owners;
        this.picture = picture;
        this.releaseDate = releaseDate;
        this.season = season;
        this.title = title;
        this.type = type;
    }


    /**
     * Gets the directorName value for this Movie.
     * 
     * @return directorName
     */
    public java.lang.String getDirectorName() {
        return directorName;
    }


    /**
     * Sets the directorName value for this Movie.
     * 
     * @param directorName
     */
    public void setDirectorName(java.lang.String directorName) {
        this.directorName = directorName;
    }


    /**
     * Gets the movieId value for this Movie.
     * 
     * @return movieId
     */
    public int getMovieId() {
        return movieId;
    }


    /**
     * Sets the movieId value for this Movie.
     * 
     * @param movieId
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


    /**
     * Gets the ownedDVD value for this Movie.
     * 
     * @return ownedDVD
     */
    public boolean isOwnedDVD() {
        return ownedDVD;
    }


    /**
     * Sets the ownedDVD value for this Movie.
     * 
     * @param ownedDVD
     */
    public void setOwnedDVD(boolean ownedDVD) {
        this.ownedDVD = ownedDVD;
    }


    /**
     * Gets the owners value for this Movie.
     * 
     * @return owners
     */
    public fr.guronzan.mediatheque.webservice.User[] getOwners() {
        return owners;
    }


    /**
     * Sets the owners value for this Movie.
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
     * Gets the picture value for this Movie.
     * 
     * @return picture
     */
    public byte[] getPicture() {
        return picture;
    }


    /**
     * Sets the picture value for this Movie.
     * 
     * @param picture
     */
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }


    /**
     * Gets the releaseDate value for this Movie.
     * 
     * @return releaseDate
     */
    public java.util.Calendar getReleaseDate() {
        return releaseDate;
    }


    /**
     * Sets the releaseDate value for this Movie.
     * 
     * @param releaseDate
     */
    public void setReleaseDate(java.util.Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }


    /**
     * Gets the season value for this Movie.
     * 
     * @return season
     */
    public java.lang.Integer getSeason() {
        return season;
    }


    /**
     * Sets the season value for this Movie.
     * 
     * @param season
     */
    public void setSeason(java.lang.Integer season) {
        this.season = season;
    }


    /**
     * Gets the title value for this Movie.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Movie.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the type value for this Movie.
     * 
     * @return type
     */
    public fr.guronzan.mediatheque.webservice.VideoType getType() {
        return type;
    }


    /**
     * Sets the type value for this Movie.
     * 
     * @param type
     */
    public void setType(fr.guronzan.mediatheque.webservice.VideoType type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Movie)) return false;
        Movie other = (Movie) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.directorName==null && other.getDirectorName()==null) || 
             (this.directorName!=null &&
              this.directorName.equals(other.getDirectorName()))) &&
            this.movieId == other.getMovieId() &&
            this.ownedDVD == other.isOwnedDVD() &&
            ((this.owners==null && other.getOwners()==null) || 
             (this.owners!=null &&
              java.util.Arrays.equals(this.owners, other.getOwners()))) &&
            ((this.picture==null && other.getPicture()==null) || 
             (this.picture!=null &&
              java.util.Arrays.equals(this.picture, other.getPicture()))) &&
            ((this.releaseDate==null && other.getReleaseDate()==null) || 
             (this.releaseDate!=null &&
              this.releaseDate.equals(other.getReleaseDate()))) &&
            ((this.season==null && other.getSeason()==null) || 
             (this.season!=null &&
              this.season.equals(other.getSeason()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getDirectorName() != null) {
            _hashCode += getDirectorName().hashCode();
        }
        _hashCode += getMovieId();
        _hashCode += (isOwnedDVD() ? Boolean.TRUE : Boolean.FALSE).hashCode();
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
        if (getSeason() != null) {
            _hashCode += getSeason().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Movie.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "movie"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("directorName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "directorName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("movieId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "movieId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownedDVD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ownedDVD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("season");
        elemField.setXmlName(new javax.xml.namespace.QName("", "season"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "videoType"));
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
