package by.tms.homework.web;

import by.tms.homework.service.DataChecking;
import by.tms.homework.service.Message;
import by.tms.homework.service.SeparationEnteredDataAndSaving;
import by.tms.homework.storage.StorageData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator") // localhost:8080/calculator?num1=2&type=+&num2=2
public class CalculatorServlet extends HttpServlet {
    private final StorageData storageData = new StorageData();
    private final SeparationEnteredDataAndSaving separationEnteredDataAndSaving = new SeparationEnteredDataAndSaving();
    private final Message message = new Message();
    private final DataChecking dataChecking = new DataChecking();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getQueryString();
        String[] parameters = query.split("&");

        separationEnteredDataAndSaving.separationEnteredDataAndSaving(parameters, storageData);

        String s = dataChecking.check(storageData, message);
        resp.getWriter().print(s);

        message.clearMessage();
        storageData.clearOperations();
        storageData.clearValue();
    }
}
