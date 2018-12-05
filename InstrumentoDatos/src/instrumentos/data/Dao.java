/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.data;

import instrumentosEntidades.Calibracion;
import instrumentosEntidades.Instrumento;
import instrumentosEntidades.Medida;
import instrumentosEntidades.TipoInstrumento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estef
 */
public class Dao {

    RelDataBase db;

    public Dao() {
        db = new RelDataBase();
    }

    public TipoInstrumento getTipoInstrumento(String codigo) throws Exception {
        String sql = "select * from TipoInstrumento where codigo='%s'";
        sql = String.format(sql, codigo);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return tipoInstrumento(rs);
        } else {
            throw new Exception("Tipo de Instrumento no Existe");
        }
    }

    private TipoInstrumento tipoInstrumento(ResultSet rs) {
        try {
            TipoInstrumento TI = new TipoInstrumento();
            TI.setCodigo(rs.getString("codigo"));
            TI.setNombre(rs.getString("nombre"));
            TI.setUnidad(rs.getString("unidad"));
            return TI;
        } catch (SQLException e) {
            return null;
        }
    }

    private Instrumento instrumento(ResultSet rs) {
        try {
            Instrumento in = new Instrumento();
            in.setSerie(rs.getString("serie"));
            in.setTipo(tipoInstrumento(rs));
            in.setDescripcion(rs.getString("descripcion"));
            in.setMinimo(rs.getInt("minimo"));
            in.setMaximo(rs.getInt("maximo"));
            in.setTolerancia(rs.getInt("tolerancia"));
            return in;
        } catch (SQLException e) {
            return null;
        }
    }

    private Calibracion calibracion(ResultSet rs) {
        try {
            Calibracion ca = new Calibracion();
            ca.setNumero(rs.getInt("numero"));
            ca.setInstrumento(instrumento(rs));
            ca.setMediciones(rs.getInt("mediciones"));
            ca.setFecha(rs.getDate("fecha"));
            return ca;
        } catch (SQLException e) {
            return null;
        }
    }

    private Medida medida(ResultSet rs) {
        try {
            Medida m = new Medida();
            m.setLectura(rs.getInt("lectura"));
            m.setNumero(rs.getInt("numero"));
            m.setReferencia(rs.getInt("referencia"));
            m.setCalibracion(calibracion(rs));
            return m;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<TipoInstrumento> TipoInstrumentoGetAll() {
        List<TipoInstrumento> resultado = new ArrayList<TipoInstrumento>();
        try {
            String sql = "select * from TipoInstrumento";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(tipoInstrumento(rs));
            }
        } catch (SQLException e) {

        }
        return resultado;
    }

    public List<TipoInstrumento> TipoInstrumentoSearch(TipoInstrumento filtro) {
        List<TipoInstrumento> resultado = new ArrayList<TipoInstrumento>();
        try {
            String sql = "select * from " + "TipoInstrumento p "
                    + "where p.nombre like '%%%s%%'";
            sql = String.format(sql, filtro.getNombre());
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(tipoInstrumento(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public void TipoInstrumentoBorrar(TipoInstrumento ti) throws Exception {
        String sql = "delete from TipoInstrumento where codigo='%s'";
        sql = String.format(sql, ti.getCodigo());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Tipo de Instrumento no existe");
        }
    }

    public void TipoInstrumentoAgregar(TipoInstrumento ti) throws Exception {
        String sql = "insert into TipoInstrumento (codigo,nombre,unidad)"
                + "values('%s','%s','%s')";
        sql = String.format(sql, ti.getCodigo(), ti.getNombre(), ti.getUnidad());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Tipo de Instrumento ya existe");
        }
    }

    public void TipoInstrumentoActualizar(TipoInstrumento p) throws Exception {
        String sql = "update tipoInstrumento set nombre= '%s',unidad = '%s' "
                + "where codigo='%s'";
        sql = String.format(sql, p.getNombre(), p.getUnidad(), p.getCodigo());
        System.out.println(sql);
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Tipo de Instrumento no existe");
        }
    }

    public List<Instrumento> InstrumentoSearch(Instrumento filtro) {
        List<Instrumento> resultado = new ArrayList<Instrumento>();
        try {
            String sql = "select * from " + " instrumento i inner join tipoinstrumento ti on i.tipo=ti.codigo "
                    + "where descripcion like '%%%s%%'";
            sql = String.format(sql, filtro.getDescripcion());
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(instrumento(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    public void InstrumentoAgregar(Instrumento ti) throws Exception {
        String sql = "insert into instrumento (serie,tipo,descripcion,minimo,maximo,tolerancia)"
                + "values('%s','%s','%s','%s','%s','%s')";
        sql = String.format(sql, ti.getSerie(), ti.getTipo().getCodigo(), ti.getDescripcion(), ti.getMinimo(), ti.getMaximo(), ti.getTolerancia());//tambien guardar el tipo de dato
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Instrumento ya existente");
        }
    }

    public void InstrumentoBorrar(Instrumento ti) throws Exception {
        String sql = "delete from Instrumento where serie='%s'";
        sql = String.format(sql, ti.getSerie());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Instrumento no existe");
        }
    }

    public void InstrumentoActualizar(Instrumento p) throws Exception {
        String sql = "update instrumento set tipo= '%s',descripcion = '%s', minimo = '%s', maximo = '%s', tolerancia = '%s'"
                + "where serie='%s'";
        sql = String.format(sql, p.getTipo().getCodigo(), p.getDescripcion(), p.getMinimo(), p.getMaximo(), p.getTolerancia(), p.getSerie());
        System.out.println(sql);
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Instrumento no existe");
        }
    }

    public List<Calibracion> CalibracionSearch(Instrumento filtro) {
        List<Calibracion> resultado = new ArrayList<Calibracion>();
        try {
            String sql = "select * from " + " calibracion c inner join instrumento i on c.instrumento=i.serie "
                    + "where serie like '%%%s%%'";
            sql = String.format(sql, filtro.getSerie());
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(calibracion(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    public void AgregarCalibracion(Calibracion c) throws Exception {
        String sql = "insert into Calibracion (instrumento,fecha,mediciones)"
                + "values('%s','%s',%d)";
        sql = String.format(sql, c.getInstrumento().getSerie(), new SimpleDateFormat("yyyy/mm/dd").format(c.getFecha()), c.getMediciones());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Calibracion ya existente");
        }
    }

    public void BorrarCalibracion(Calibracion ti) throws Exception {
        String sql2 = "delete from Medida where Calibracion =%d";
        String sql = "delete from Calibracion where numero=%d";
        sql2 = String.format(sql2, ti.getNumero());
        sql = String.format(sql, ti.getNumero());
        System.out.println(sql);
        int count2 = db.executeUpdate(sql2);
        int count = db.executeUpdate(sql);
        if (count == 0 || count2 == 0) {
            throw new Exception("Calibracion no existe");
        }
    }

    public List<Medida> MedidaSearch(Calibracion filtro) {
        List<Medida> resultado = new ArrayList<Medida>();
        try {
            String sql = "select * from " + " Medida m inner join Calibracion c on m.calibracion=c.numero "
                    + "where numero=%d";
            sql = String.format(sql, filtro.getNumero());
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(medida(rs));
            }
        } catch (SQLException ex) {
        }
        return resultado;

    }

    public void AgregarMedida(Medida m) throws Exception {
        String sql = "insert into Medida(calibracion,medida,referencia,lectura)"
                + "values(%d,%d,%d,%d)";
        sql = String.format(sql, m.getCalibracion().getNumero(), m.getNumero(), m.getReferencia(), m.getLectura());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Medida ya existente");
        }
    }

    public void MedidaBorrar(Calibracion c) throws Exception {
        String sql = "delete from medida where calibracion=%d";
        sql = String.format(sql, c.getNumero());
        System.out.println(sql);
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Medida no existe");
        }
    }

    public void MedidaActualizar(Medida m) throws Exception {
        String sql = "update Medida set lectura= %d, referencia = %d,"
                + "where medida=%d";
        sql = String.format(sql, m.getLectura(), m.getReferencia(),m.getNumero());
        System.out.println(sql);
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Medida no existe");
        }
    }

    public void close() {

    }

}
