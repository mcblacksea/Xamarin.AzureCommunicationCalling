package com.laerdal.azurecommunicationhelper;

import android.content.Context;
import com.azure.android.communication.calling.Call;
import com.azure.android.communication.calling.CallAgent;
import com.azure.android.communication.calling.CallClient;
import com.azure.android.communication.calling.DeviceManager;
import com.azure.android.communication.calling.HangUpOptions;
import com.azure.android.communication.calling.StartCallOptions;
import com.azure.android.communication.common.CommunicationIdentifier;
import com.azure.android.communication.common.CommunicationTokenCredential;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CallClientHelper {
    public static CallAgent GetCallAgent(
            CallClient callClient,
            Context context,
            CommunicationTokenCredential credentials) throws ExecutionException, InterruptedException {
        return callClient.createCallAgent(context, credentials).get();
    }

    public static void HangUp(Call call, HangUpOptions options) throws ExecutionException, InterruptedException {
        call.hangUp(options).get();
    }

    public static Call Call(
            CallAgent callAgent,
            Context context,
            List<CommunicationIdentifier> participants,
            StartCallOptions startCallOptions) {
        return callAgent.startCall(context, participants, startCallOptions);
    }

    public static DeviceManager GetDeviceManager(
            CallClient callClient,
            Context context
    ) throws ExecutionException, InterruptedException {
        return callClient.getDeviceManager(context).get();
    }

}
