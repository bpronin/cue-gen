data class TrackTime(val minutes: Int, val seconds: Byte, val frames: Byte)

data class Track(val index: Int, val title: String, val performer: String, val time: TrackTime)
