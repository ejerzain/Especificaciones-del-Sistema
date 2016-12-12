package info_sistema;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import java.io.*;
import javax.swing.JOptionPane;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NfsFileSystem;
import org.hyperic.sigar.SigarProxy;
import org.hyperic.sigar.SigarProxyCache;
import org.hyperic.sigar.Swap;
/**
* @author ejerzain
 */
public class Info_Sistema {
String salida = null;

public String obtenerInfoSistema() throws SigarExcption{
String Resultado=null;
OperatingSystem sys = OperatingSystem.getInstance();
        Resultado="Descripcion del SO:\t" + sys.getDescription()+"\r\n";
        Resultado+="Nombre del SO:\t" + sys.getName()+"\r\n";
        Resultado+="Arquitectura del SO:\t" + sys.getArch()+"\r\n";
        Resultado+="Version del SO:\t" + sys.getVersion()+"\r\n";
        Resultado+="Nivel de parches:\t" + sys.getPatchLevel()+"\r\n";
        Resultado+="Fabricante:\t" + sys.getVendor()+"\r\n";
        Resultado+="Version SO:\t" + sys.getVendorVersion()+"\r\n";    
return Resultado;
}

public String obtenerInfoMemoria() throws SigarException{
String Resultado=null;
Sigar sigar = new Sigar();
Mem memoria = sigar.getMem();
        Swap intercambio = sigar.getSwap();
        Resultado="Cantidad de memoria RAM: "+ memoria.getRam() +" MB"+"\r\n";
        Resultado+="Total: "+memoria.getTotal()/1024+" KB"+"\r\n";
        Resultado+="Usada: "+memoria.getUsed()/1024+" KB"+"\r\n";
        Resultado+="Disponible: "+memoria.getFree()/1024+" KB"+"\r\n";
        Resultado+="Memoria SWAP total: "+intercambio.getTotal()/1024+" KB"+"\r\n";
        Resultado+="Memoria SWAP usada: "+intercambio.getUsed()/1024+" KB"+"\r\n";
        Resultado+="Memoria SWAP libre: "+intercambio.getFree()/1024+" KB"+"\r\n";
return Resultado;
}

public String obtenerInfoCPU() throws SigarException{
String Resultado=null;
Sigar sigar = new Sigar();
        CpuInfo[] infos = null;
        CpuPerc[] cpus = null;
        try {
            infos = sigar.getCpuInfoList();
            cpus = sigar.getCpuPercList();
        } catch (SigarException e) {
            e.printStackTrace();
        }
        CpuInfo info = infos[0];
        long tamanioCache = info.getCacheSize();
        Resultado="Fabricante:\t" + info.getVendor()+"\r\n";
        Resultado+="Modelo:\t" + info.getModel()+"\r\n";
        Resultado+="Velocidad de reloj:\t\t" + info.getMhz()+"\r\n";
        Resultado+="Total CPUs:\t" + info.getTotalCores()+"\r\n";
        if ((info.getTotalCores() != info.getTotalSockets())
                || (info.getCoresPerSocket() > info.getTotalCores())) {
            Resultado+="CPUs fisiscas:\t" + info.getTotalSockets()+"\r\n";
            Resultado+="Núcleos por CPU:\t" + info.getCoresPerSocket()+"\r\n";
        }
        if (tamanioCache != Sigar.FIELD_NOTIMPL)
            Resultado+="Tamanio cache:\t" + tamanioCache+"\r\n";

        for (int i = 0; i < cpus.length; i++)
            Resultado+="Consumo de CPU " + i + "\t" + CpuPerc.format(cpus[i].getUser())+"\r\n";;
        try { 
            Resultado+="Consumo total de CPU\t" + CpuPerc.format(sigar.getCpuPerc().getUser())+"\r\n";;
        } catch (SigarException e) {
            e.printStackTrace();
        }
return Resultado;
}

public String obtenerInfoDiscos() throws SigarException{
String Resultado="";
  SigarProxy proxy;
  Sigar sigar=new Sigar();
 proxy = SigarProxyCache.newInstance(sigar);
FileSystem[] listaSistemaArchivos = proxy.getFileSystemList();
Resultado="\r\nUnidad   |   Espacio total   |   Espacio usado   |   Espacio disponible   |   %uso   |   Directorio   |   Tipo\r\n";
        for(int i = 0; i < listaSistemaArchivos.length; i++){
            Resultado+=imprimirSistemaArchivos(listaSistemaArchivos[i]);
        }
 return Resultado;
}

 private String imprimirSistemaArchivos(FileSystem sistemaArchivos) throws SigarException {
        long usado=0, disponible=0, total=0, porcentaje=0;
        String r="";
        Sigar sigar=new Sigar();
        try{
        FileSystemUsage uso;
        if (sistemaArchivos instanceof NfsFileSystem) {
            NfsFileSystem nfs = (NfsFileSystem) sistemaArchivos;
            if (!nfs.ping()) {
                r+=(nfs.getUnreachableMessage());
                return "";
            }
        }
        uso = sigar.getFileSystemUsage(sistemaArchivos.getDirName());
        usado = uso.getTotal() - uso.getFree();
        disponible = uso.getAvail();
        total = uso.getTotal();
        porcentaje = (long) (uso.getUsePercent() * 100);
        }
        catch(SigarException e){
        }
        String porcentajeUso;
        if (porcentaje == 0)
            porcentajeUso = "-";
        else
            porcentajeUso = porcentaje + "%";
        r+=sistemaArchivos.getDevName();
        r+="|   " + total+" KB"+"\t";
        r+="|   " + usado+" KB"+"\t";
        r+="|   " + disponible+" KB"+"\t";
        r+="|   " + porcentajeUso+"\t";
        r+="|   " + sistemaArchivos.getDirName()+"\t";
        r+="|   " + sistemaArchivos.getSysTypeName()+"\t"+"\r\n";
    return r;
    }


public void guardarEnArchivo(String texto){
try{
    File archivo=new File("Informacion_Sistema.txt");
    FileWriter w = new FileWriter(archivo);
    BufferedWriter bw = new BufferedWriter(w);
    PrintWriter wr = new PrintWriter(bw);	
    wr.write("Información del sistema:\r\n"+texto);//escribimos en el archivo 
    wr.close();
    bw.close();
    JOptionPane.showMessageDialog( null,"El archivo se guardó correctamente");
}
catch(IOException e){
JOptionPane.showMessageDialog( null,"No se pudo guardar el archivo");
}
}

}
