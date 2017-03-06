package itsco.edu.agenda;

/**
 * Created by betom on 05/03/2017.
 */
import android.os.Parcel;
import android.os.Parcelable;

public class tarea implements Parcelable {

    private String Nombre;
    private String Telefono;
    private String correo;

    public tarea() {
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(Nombre);
        dest.writeString(Telefono);
        dest.writeString(correo);

    }

    private tarea(Parcel parcel) {
        this.setNombre(parcel.readString());
        this.setTelefono(parcel.readString());
        this.setCorreo(parcel.readString());
    }


    public static final Parcelable.Creator<tarea> CREATOR
            = new Parcelable.Creator<tarea>() {
        @Override
        public tarea createFromParcel(Parcel source) {
            return new tarea();
        }

        @Override
        public tarea[] newArray(int i) {
            return new tarea[i];
        }
    };


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {return this.Telefono;}
}

