/**
 * User.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.guronzan.mediatheque.webservice;

public class User  extends fr.guronzan.mediatheque.webservice.DomainObject  implements java.io.Serializable {
    private byte[] avatar;

    private fr.guronzan.mediatheque.webservice.Book[] books;

    private fr.guronzan.mediatheque.webservice.Cd[] cds;

    private java.lang.String forName;

    private fr.guronzan.mediatheque.webservice.Movie[] movies;

    private java.lang.String name;

    private java.lang.String nickName;

    private java.lang.String password;

    private java.util.Calendar registrationDate;

    private int userId;

    public User() {
    }

    public User(
           byte[] avatar,
           fr.guronzan.mediatheque.webservice.Book[] books,
           fr.guronzan.mediatheque.webservice.Cd[] cds,
           java.lang.String forName,
           fr.guronzan.mediatheque.webservice.Movie[] movies,
           java.lang.String name,
           java.lang.String nickName,
           java.lang.String password,
           java.util.Calendar registrationDate,
           int userId) {
        this.avatar = avatar;
        this.books = books;
        this.cds = cds;
        this.forName = forName;
        this.movies = movies;
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.registrationDate = registrationDate;
        this.userId = userId;
    }


    /**
     * Gets the avatar value for this User.
     * 
     * @return avatar
     */
    public byte[] getAvatar() {
        return avatar;
    }


    /**
     * Sets the avatar value for this User.
     * 
     * @param avatar
     */
    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }


    /**
     * Gets the books value for this User.
     * 
     * @return books
     */
    public fr.guronzan.mediatheque.webservice.Book[] getBooks() {
        return books;
    }


    /**
     * Sets the books value for this User.
     * 
     * @param books
     */
    public void setBooks(fr.guronzan.mediatheque.webservice.Book[] books) {
        this.books = books;
    }

    public fr.guronzan.mediatheque.webservice.Book getBooks(int i) {
        return this.books[i];
    }

    public void setBooks(int i, fr.guronzan.mediatheque.webservice.Book _value) {
        this.books[i] = _value;
    }


    /**
     * Gets the cds value for this User.
     * 
     * @return cds
     */
    public fr.guronzan.mediatheque.webservice.Cd[] getCds() {
        return cds;
    }


    /**
     * Sets the cds value for this User.
     * 
     * @param cds
     */
    public void setCds(fr.guronzan.mediatheque.webservice.Cd[] cds) {
        this.cds = cds;
    }

    public fr.guronzan.mediatheque.webservice.Cd getCds(int i) {
        return this.cds[i];
    }

    public void setCds(int i, fr.guronzan.mediatheque.webservice.Cd _value) {
        this.cds[i] = _value;
    }


    /**
     * Gets the forName value for this User.
     * 
     * @return forName
     */
    public java.lang.String getForName() {
        return forName;
    }


    /**
     * Sets the forName value for this User.
     * 
     * @param forName
     */
    public void setForName(java.lang.String forName) {
        this.forName = forName;
    }


    /**
     * Gets the movies value for this User.
     * 
     * @return movies
     */
    public fr.guronzan.mediatheque.webservice.Movie[] getMovies() {
        return movies;
    }


    /**
     * Sets the movies value for this User.
     * 
     * @param movies
     */
    public void setMovies(fr.guronzan.mediatheque.webservice.Movie[] movies) {
        this.movies = movies;
    }

    public fr.guronzan.mediatheque.webservice.Movie getMovies(int i) {
        return this.movies[i];
    }

    public void setMovies(int i, fr.guronzan.mediatheque.webservice.Movie _value) {
        this.movies[i] = _value;
    }


    /**
     * Gets the name value for this User.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this User.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the nickName value for this User.
     * 
     * @return nickName
     */
    public java.lang.String getNickName() {
        return nickName;
    }


    /**
     * Sets the nickName value for this User.
     * 
     * @param nickName
     */
    public void setNickName(java.lang.String nickName) {
        this.nickName = nickName;
    }


    /**
     * Gets the password value for this User.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this User.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the registrationDate value for this User.
     * 
     * @return registrationDate
     */
    public java.util.Calendar getRegistrationDate() {
        return registrationDate;
    }


    /**
     * Sets the registrationDate value for this User.
     * 
     * @param registrationDate
     */
    public void setRegistrationDate(java.util.Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }


    /**
     * Gets the userId value for this User.
     * 
     * @return userId
     */
    public int getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this User.
     * 
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.avatar==null && other.getAvatar()==null) || 
             (this.avatar!=null &&
              java.util.Arrays.equals(this.avatar, other.getAvatar()))) &&
            ((this.books==null && other.getBooks()==null) || 
             (this.books!=null &&
              java.util.Arrays.equals(this.books, other.getBooks()))) &&
            ((this.cds==null && other.getCds()==null) || 
             (this.cds!=null &&
              java.util.Arrays.equals(this.cds, other.getCds()))) &&
            ((this.forName==null && other.getForName()==null) || 
             (this.forName!=null &&
              this.forName.equals(other.getForName()))) &&
            ((this.movies==null && other.getMovies()==null) || 
             (this.movies!=null &&
              java.util.Arrays.equals(this.movies, other.getMovies()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.nickName==null && other.getNickName()==null) || 
             (this.nickName!=null &&
              this.nickName.equals(other.getNickName()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.registrationDate==null && other.getRegistrationDate()==null) || 
             (this.registrationDate!=null &&
              this.registrationDate.equals(other.getRegistrationDate()))) &&
            this.userId == other.getUserId();
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
        if (getAvatar() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAvatar());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAvatar(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBooks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBooks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBooks(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getForName() != null) {
            _hashCode += getForName().hashCode();
        }
        if (getMovies() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMovies());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMovies(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getNickName() != null) {
            _hashCode += getNickName().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getRegistrationDate() != null) {
            _hashCode += getRegistrationDate().hashCode();
        }
        _hashCode += getUserId();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(User.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "user"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avatar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avatar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("books");
        elemField.setXmlName(new javax.xml.namespace.QName("", "books"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "book"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "cd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("movies");
        elemField.setXmlName(new javax.xml.namespace.QName("", "movies"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "movie"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nickName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nickName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registrationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
