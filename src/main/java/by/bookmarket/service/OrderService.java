package by.bookmarket.service;

import by.bookmarket.dao.order.InMemoryOrderDao;
import by.bookmarket.dao.order.OrderDaoDB;
import by.bookmarket.entity.order.Order;
import by.bookmarket.entity.user.User;
import by.bookmarket.errors.IdDoesntExist;
import by.bookmarket.errors.IsEmptyException;
import by.bookmarket.errors.UsersByIdDoesntMatch;

import java.util.List;

public class OrderService {
    private OrderDaoDB oDDB = new OrderDaoDB();
    private InMemoryOrderDao iMOD = new InMemoryOrderDao();

    public boolean synchronizedSave(Order order) {
        if (iMOD.contains(order.getId()) && oDDB.contains(order.getId())) {
            return false;
        } else {
            oDDB.save(order);
            iMOD.save(oDDB.getById(order.getId()));
        }
        return true;
    }

    public void synchronizedDelete(int id) {
        if (iMOD.contains(id) && oDDB.contains(id)) {
            if (iMOD.getById(id).equals(oDDB.getById(id))) {
                iMOD.deleteById(id);
                oDDB.deleteById(id);
                return;
            }
            throw new UsersByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }
    public List<Order> getAllFromInMemory(){
        if (iMOD.getAll().isEmpty()){
            throw new IsEmptyException();
        }
        return iMOD.getAll();
    }

    public List<Order> getAllFromDB(){
        if (oDDB.getAll().isEmpty()){
            throw new IsEmptyException();
        }
        return oDDB.getAll();
    }
    public void synchronize(){
        iMOD.save(oDDB.getAll());
    }
}
