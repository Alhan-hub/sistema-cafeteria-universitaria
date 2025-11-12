package com.cafeteria.frontend;

import com.cafeteria.frontend.window.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import javax.swing.*;

@SpringBootApplication
@EnableFeignClients // Habilita los clientes Feign
public class CafeteriaFrontendApplication {

    public static void main(String[] args) {
        // Importante para que Spring Boot permita iniciar Swing
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(CafeteriaFrontendApplication.class, args);
    }

    // Define un CommandLineRunner para mostrar la ventana principal de Swing
    @Bean
    public CommandLineRunner showMainFrame(MainFrame mainFrame) {
        return args -> {
            // Ejecutar la UI de Swing en el Event Dispatch Thread (EDT)
            SwingUtilities.invokeLater(() -> {
                mainFrame.initializeUI();
                mainFrame.setVisible(true);
            });
        };
    }
}