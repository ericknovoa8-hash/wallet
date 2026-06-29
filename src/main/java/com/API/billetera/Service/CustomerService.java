package com.API.billetera.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.API.billetera.dto.request.CustomerRequestDTO;
import com.API.billetera.dto.response.CustomerResponseDTO;
import com.API.billetera.dto.response.HttpGlovalResponseDTO;
import com.API.billetera.dto.response.MessageResponseDTO;
import com.API.billetera.entity.Customer;
import com.API.billetera.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CustomerService {
    /**
     * En esta clase implementaremos los metodos de crear, eliminar, actualizar o obtener 
     * los datos del cliente.
     */
    private final CustomerRepository customerRepository;
    /**
     * Con este metodo creamos a los clientes para la billetera 
     * @param request
     * @return
     */
    public MessageResponseDTO createCustomer(CustomerRequestDTO request){
        /**
         * se crea los usuarios para la billetera 
         */
        Optional<Customer> existing = customerRepository.findByDocumentNumber(request.getDocumentNumber());
        if(existing.isPresent()){
            throw new RuntimeException();

        }
        Customer customer = new Customer();

        customer.setDocumentNumber(request.getDocumentNumber());
        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setPhoneNumber(request.getPhoneNumber());
        
        customerRepository.save(customer);

        MessageResponseDTO response = new MessageResponseDTO();
        
        response.setMessage("El usuario ha sido registrado exitosamente.");
        return response;
    }
    /**
     * con este metodo listamos a los clientes 
     * @return
     */
    public List<CustomerResponseDTO> getCustomers(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> response = new ArrayList<>();

        for(Customer customer: customers){
            CustomerResponseDTO dto = new CustomerResponseDTO();

            dto.setDocumentNumber(customer.getDocumentNumber());
            dto.setFullName(customer.getFullName());
            dto.setEmail(customer.getEmail());
            dto.setPhoneNumber(customer.getPhoneNumber());
            response.add(dto);

        }
        return response;
    }
    /**
     * con este metodo podemos obtener un cliente especifico
     * @param id
     * @return
     */
    public HttpGlovalResponseDTO<CustomerResponseDTO> getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
            ()-> new RuntimeException("Cliente no encontrado"));

            CustomerResponseDTO responseCustomer = new CustomerResponseDTO();
            responseCustomer.setId(customer.getId());
            responseCustomer.setDocumentNumber(customer.getDocumentNumber());
            responseCustomer.setFullName(customer.getFullName());
            responseCustomer.setEmail(customer.getEmail());
            responseCustomer.setPhoneNumber(customer.getPhoneNumber());

            HttpGlovalResponseDTO<CustomerResponseDTO> response = new HttpGlovalResponseDTO<>();
            return response;
    }
    /**
     * con este metodo hacemos las actualizaciones de los clientes 
     * @param id
     * @param request
     * @return
     */
    public CustomerResponseDTO updateCustomer(Long id, CustomerResponseDTO request) {
        Customer customer = customerRepository.findById(id).orElseThrow(
            ()-> new RuntimeException("Cliente no encontrado "));

            customer.setDocumentNumber(request.getDocumentNumber());
            customer.setFullName(request.getFullName());
            customer.setEmail(request.getEmail());
            customer.setPhoneNumber(request.getPhoneNumber());

            CustomerResponseDTO responseCustomer = new CustomerResponseDTO();
            responseCustomer.setId(customer.getId());
            responseCustomer.setDocumentNumber(customer.getDocumentNumber());
            responseCustomer.setFullName(customer.getFullName());
            responseCustomer.setEmail(customer.getEmail());
            responseCustomer.setPhoneNumber(customer.getPhoneNumber());

            return responseCustomer;

    }
    /**
     * Creamos los metodos para eliminar a los clientes 
     * @param id
     * @return
     */
    public MessageResponseDTO deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
            ()-> new RuntimeException("Cliente no encontrado "));

            customerRepository.delete(customer);
            MessageResponseDTO response  = new MessageResponseDTO();

            response.setMessage("Cliente eliminado correctemente");
            return response;
    }
    /**
     * Buscar los clientes por su nombre.
     * @param name
     * @return
     */
    public List<CustomerResponseDTO>searchCustomer(String name) {

        List<Customer> customers = customerRepository.findByFullName(name);
        List<CustomerResponseDTO> response = new ArrayList<>();

        for(Customer customer : customers) {
            CustomerResponseDTO dto = new CustomerResponseDTO();
            dto.setDocumentNumber(customer.getDocumentNumber());
            dto.setFullName(customer.getFullName());
            dto.setEmail(customer.getEmail());
            dto.setPhoneNumber(customer.getPhoneNumber());
        }
        return response;
    }

}
