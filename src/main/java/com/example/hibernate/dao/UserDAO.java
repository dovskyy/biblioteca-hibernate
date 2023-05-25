package com.example.hibernate;

    /*
    Alternatywnie, UserDAO może być również zwykłą klasą, która zawiera pełną implementację operacji na danych dla encji User.
    To podejście jest mniej elastyczne niż interfejs, ale może być stosowane w prostszych przypadkach, gdzie wymagane są tylko
    konkretne operacje i brak potrzeby abstrakcji. Użycie interfejsu UserDAO jest jednym z popularnych podejść przy implementacji
    wzorca projektowego DAO (Data Access Object).
     */

import java.util.List;

public interface UserDAO {
    void saveUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
    User getUser(int id);
}
