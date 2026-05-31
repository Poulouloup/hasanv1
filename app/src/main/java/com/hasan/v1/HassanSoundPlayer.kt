package com.hasan.v1

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool

object HassanSoundPlayer {

    private var soundPool: SoundPool? = null
    private var wakeId: Int = 0
    private var endId: Int  = 0
    private var ready = false

    fun init(context: Context) {
        if (ready) return

        val attrs = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        val pool = SoundPool.Builder()
            .setMaxStreams(4)
            .setAudioAttributes(attrs)
            .build()

        val am = context.assets
        wakeId = pool.load(am.openFd("wake.wav"), 1)
        endId  = pool.load(am.openFd("done.wav"), 1)

        soundPool = pool
        ready = true
    }

    fun playWake() { soundPool?.play(wakeId, 1f, 1f, 1, 0, 1f) }
    fun playEnd()  { soundPool?.play(endId,  1f, 1f, 1, 0, 1f) }

    fun release() {
        soundPool?.release()
        soundPool = null
        ready = false
        wakeId = 0
        endId  = 0
    }
}
