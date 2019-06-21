package apps.rez.com.smartguru.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/3/17.
 */

public class Siswa {
    @SerializedName("nisn")
    private String nisn;
    @SerializedName("nama_ibu")
    private String namaIbu;
    @SerializedName("alamat_ibu")
    private String alamatIbu;
    @SerializedName("nama_wali")
    private String namaWali;
    @SerializedName("agama")
    private String agama;
    @SerializedName("pekerjaan_ibu")
    private String pekerjaanIbu;
    @SerializedName("pekerjaan_wali")
    private String pekerjaanWali;
    @SerializedName("alamat_wali")
    private String alamatWali;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("nama")
    private String nama;
    @SerializedName("tempat_lahir")
    private String tempatLahir;
    @SerializedName("nama_ayah")
    private String namaAyah;
    @SerializedName("nis")
    private String nis;
    @SerializedName("alamat_ayah")
    private String alamatAyah;
    @SerializedName("jenis_kelamin")
    private String jenisKelamin;
    @SerializedName("pekerjaan_ayah")
    private String pekerjaanAyah;
    @SerializedName("tanggal_lahir")
    private String tanggalLahir;

    public Siswa(){}

    public Siswa(String nisn, String namaIbu, String alamatIbu, String namaWali, String agama, String pekerjaanIbu, String pekerjaanWali, String alamatWali, String alamat, String nama, String tempatLahir, String namaAyah, String nis, String alamatAyah, String jenisKelamin, String pekerjaanAyah, String tanggalLahir) {
        this.nisn = nisn;
        this.namaIbu = namaIbu;
        this.alamatIbu = alamatIbu;
        this.namaWali = namaWali;
        this.agama = agama;
        this.pekerjaanIbu = pekerjaanIbu;
        this.pekerjaanWali = pekerjaanWali;
        this.alamatWali = alamatWali;
        this.alamat = alamat;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.namaAyah = namaAyah;
        this.nis = nis;
        this.alamatAyah = alamatAyah;
        this.jenisKelamin = jenisKelamin;
        this.pekerjaanAyah = pekerjaanAyah;
        this.tanggalLahir = tanggalLahir;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getAlamatIbu() {
        return alamatIbu;
    }

    public void setAlamatIbu(String alamatIbu) {
        this.alamatIbu = alamatIbu;
    }

    public String getNamaWali() {
        return namaWali;
    }

    public void setNamaWali(String namaWali) {
        this.namaWali = namaWali;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getPekerjaanIbu() {
        return pekerjaanIbu;
    }

    public void setPekerjaanIbu(String pekerjaanIbu) {
        this.pekerjaanIbu = pekerjaanIbu;
    }

    public String getPekerjaanWali() {
        return pekerjaanWali;
    }

    public void setPekerjaanWali(String pekerjaanWali) {
        this.pekerjaanWali = pekerjaanWali;
    }

    public String getAlamatWali() {
        return alamatWali;
    }

    public void setAlamatWali(String alamatWali) {
        this.alamatWali = alamatWali;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getAlamatAyah() {
        return alamatAyah;
    }

    public void setAlamatAyah(String alamatAyah) {
        this.alamatAyah = alamatAyah;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPekerjaanAyah() {
        return pekerjaanAyah;
    }

    public void setPekerjaanAyah(String pekerjaanAyah) {
        this.pekerjaanAyah = pekerjaanAyah;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
}