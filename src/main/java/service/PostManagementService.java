package service;

import model.Jugador;


import java.util.List;

public interface PostManagementService {
    List<Jugador>  list();
    boolean add(Jugador jugador);
    boolean edit(String name,Jugador jugador);
    boolean delete(String name);





}
