package com.mobilebe;

import com.mobilebe.dto.RoomStatus;
import com.mobilebe.entity.Hotel;
import com.mobilebe.entity.RoomDetailEntity;
import com.mobilebe.repository.HotelRepository;
import com.mobilebe.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AutoSeed implements CommandLineRunner {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public void run(String... args) throws Exception {

            loadData();
    }
    private void loadData() {
        if (roomRepository.count() == 0 && hotelRepository.count() == 0) {
            Hotel hotel = Hotel.builder()
                    .hotel_name("Sample Hotel")
                    .hotel_location("123 Sample Street")
                    .manager_name("SOS")
                    .build();

            hotelRepository.save(hotel);

            Random random = new Random();

            for (int i = 0; i < 5; i++) {
                RoomDetailEntity room = RoomDetailEntity.builder()
                        .room_number("Room" + (i + 1))
                        .room_floor(random.nextInt(5) + 1)
                        .room_type("Type" + (i + 1))
                        .room_price(random.nextInt(100) + 50)  // Giá ngẫu nhiên từ 50 đến 149
                        .room_desciption("Description" + (i + 1))
                        .number_of_beds(random.nextInt(3) + 1)  // Số giường ngẫu nhiên từ 1 đến 3
                        .room_status(RoomStatus.AVAILABLE)
                        .hotel(hotel)
                        .build();

                roomRepository.save(room);
            }
        }
    }
}
