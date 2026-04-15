package pe.edu.upeu.repository;

import pe.edu.upeu.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    public static ClienteRepository instance=new ClienteRepository ();
    public static ClienteRepository getInstance(){
        if(instance==null){
            instance=new ClienteRepository();

        }
        return instance;
    }
    List<Cliente> clientes=new ArrayList<>();
    public void save(Cliente cliente){
        clientes.add(cliente);
    }
    //report
    public List<Cliente> finAll(){
        return clientes;
    }
    //update
    public void update(Cliente c, int index){
        clientes.set(index, c);
    }
    //Delete
    public void delete(int index){
        clientes.remove(index);
    }

}
