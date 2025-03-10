package com.gsm.dao.impl;

import com.gsm.bean.Prize;
import com.gsm.dao.inter.PrizeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrizeDAOImpl implements PrizeDAO {

    @Override
    public void addPrize(Prize prize) throws Exception {
        String sql = "INSERT INTO Prizes (EventID, PrizeLevel, PrizeName, PrizeImageURL, PrizeType, Probability, RedemptionCode, RedemptionInstructions) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, prize.getEventID());
            stmt.setString(2, prize.getPrizeLevel());
            stmt.setString(3, prize.getPrizeName());
            stmt.setString(4, prize.getPrizeImageURL());
            stmt.setString(5, prize.getPrizeType());
            stmt.setDouble(6, prize.getProbability());
            stmt.setString(7, prize.getRedemptionCode());
            stmt.setString(8, prize.getRedemptionInstructions());
            stmt.executeUpdate();
        }
    }

    @Override
    public void updatePrize(Prize prize) throws Exception {
        String sql = "UPDATE Prizes SET PrizeLevel = ?, PrizeName = ?, PrizeImageURL = ?, PrizeType = ?, Probability = ?, RedemptionCode = ?, RedemptionInstructions = ? WHERE PrizeID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prize.getPrizeLevel());
            stmt.setString(2, prize.getPrizeName());
            stmt.setString(3, prize.getPrizeImageURL());
            stmt.setString(4, prize.getPrizeType());
            stmt.setDouble(5, prize.getProbability());
            stmt.setString(6, prize.getRedemptionCode());
            stmt.setString(7, prize.getRedemptionInstructions());
            stmt.setInt(8, prize.getPrizeID());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletePrize(int prizeID) throws Exception {
        String sql = "DELETE FROM Prizes WHERE PrizeID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, prizeID);
            stmt.executeUpdate();
        }
    }

    @Override
    public Prize getPrizeById(int prizeID) throws Exception {
        String sql = "SELECT * FROM Prizes WHERE PrizeID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, prizeID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractPrize(rs);
            }
        }
        return null;
    }

    @Override
    public List<Prize> getPrizesByEventId(int eventID) throws Exception {
        String sql = "SELECT * FROM Prizes WHERE EventID = ?";
        List<Prize> prizes = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eventID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                prizes.add(extractPrize(rs));
            }
        }
        return prizes;
    }

    private Prize extractPrize(ResultSet rs) throws Exception {
        Prize prize = new Prize();
        prize.setPrizeID(rs.getInt("PrizeID"));
        prize.setEventID(rs.getInt("EventID"));
        prize.setPrizeLevel(rs.getString("PrizeLevel"));
        prize.setPrizeName(rs.getString("PrizeName"));
        prize.setPrizeImageURL(rs.getString("PrizeImageURL"));
        prize.setPrizeType(rs.getString("PrizeType"));
        prize.setProbability(rs.getDouble("Probability"));
        prize.setRedemptionCode(rs.getString("RedemptionCode"));
        prize.setRedemptionInstructions(rs.getString("RedemptionInstructions"));
        return prize;
    }
}
