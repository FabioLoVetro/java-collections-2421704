package com.linkedin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {
		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list. 
		 */
		List<Guest> list = new ArrayList<>();
		guests.stream()
				.filter(guest -> guest.getPreferredRooms().size()>0)
				.filter(guest -> guest.getPreferredRooms().get(0).equals(room))
				.forEach(guest -> list.add(guest));
		return list;

	}

	public void checkIn(Guest guest) {
		/*
		 *  2. Adds a guest to the checkinList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */
		if(!guest.isLoyaltyProgramMember()||checkinList.size()==0)
			checkinList.add(guest);
		else {
			checkinList.add(
					checkinList.indexOf(
						checkinList.stream().filter(g -> !g.isLoyaltyProgramMember())
							.findFirst().get())
					,guest);
		}
	}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */
		if(this.checkinList.containsAll(List.of(guest1,guest2))) {
			int indexGuest1 = this.checkinList.indexOf(guest1);
			int indexGuest2 = this.checkinList.indexOf(guest2);
			Guest guest = guest1;
			Guest[] guests = this.checkinList.toArray(new Guest[0]);
			guests[indexGuest1]=guest2;
			guests[indexGuest2]=guest;
			this.checkinList.clear();
			for (Guest g : guests) {
				this.checkinList.add(g);
			};
		}
	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
